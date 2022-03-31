package integration;

import connection.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolver;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class AddressResolverIT {


    AddressResolver addressResolver;

    @BeforeEach
    public void init(){
        addressResolver = new AddressResolver(new TqsBasicHttpClient());
    }

    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {

        //todo

        // repeat the same tests conditions from AddressResolverTest, without mocks

        Optional<Address> address = addressResolver.findAddressForLocation(40.6318, -8.658);

        assertTrue(address.isPresent());
        
        assertEquals(address.get().getCirty(), "Glória e Vera Cruz"); // city = adminArea5 
        assertEquals(address.get().getRoad(), "Parque Estacionamento da Reitoria - Univerisdade de Aveiro"); // road = street
        assertEquals(address.get().getState(), "Centro"); // state = adminArea3
        assertEquals(address.get().getZio(), "3810-193"); // zip = postalCode
    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddrress() throws IOException, URISyntaxException, ParseException {

        //todo
        // repeat the same tests conditions from AddressResolverTest, without mocks
        
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
