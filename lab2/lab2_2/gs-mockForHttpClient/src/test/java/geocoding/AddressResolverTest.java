package geocoding;

import connection.ISimpleHttpClient;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @Mock ISimpleHttpClient httpClient;
    @InjectMocks AddressResolver addressResolver;
    String response = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\u00A9 2022 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\u00A9 2022 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInputv\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.6318,\"lng\":-8.658}},\"locations\":[{\"street\":\"Parque Estacionamento da Reitoria - Univerisdade de Aveiro\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Gl\u00F3ria e Vera Cruz\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3810-193\",\"geocodeQualityCode\":\"P1AAA\",\"geocodeQuality\":\"POINT\",\"dragPoint\":false,\"sideOfStreetv\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"displayLatLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.6318025,-8.657881|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-472034917\",\"roadMetadata\":null}]}]}";
    String url = "http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.6318,-8.658&includeRoadMetadata=true";
    
    @Test
    public void testFindAddressForLocation() throws ParseException, IOException, URISyntaxException {
        
        Mockito.when(httpClient.doHttpGet(url)).thenReturn(response);

        Optional<Address> address = addressResolver.findAddressForLocation(40.6318,-8.658);

        assertTrue(address.isPresent());

        // Analyzing the json response

        assertEquals(address.get().getCirty(), "Glória e Vera Cruz"); // city = adminArea5 
        assertEquals(address.get().getRoad(), "Parque Estacionamento da Reitoria - Univerisdade de Aveiro"); // road = street
        assertEquals(address.get().getState(), "Centro"); // state = adminArea3
        assertEquals(address.get().getZio(), "3810-193"); // zip = postalCode
    }

    @Test
    public void badCoordinates() throws ParseException, IOException, URISyntaxException {

        Optional<Address> resultMinLatitude = addressResolver.findAddressForLocation(-91, -8.658);
        Optional<Address> resultMaxLatitude = addressResolver.findAddressForLocation(91, -8.658);
        Optional<Address> resultMinLongitude = addressResolver.findAddressForLocation(40.6318, -181);
        Optional<Address> resultMaxLongitude = addressResolver.findAddressForLocation(40.6318, 181);
    
        assertFalse(resultMinLatitude.isPresent());
        assertFalse(resultMaxLatitude.isPresent());
        assertFalse(resultMinLongitude.isPresent());
        assertFalse(resultMaxLongitude.isPresent());
    }
}