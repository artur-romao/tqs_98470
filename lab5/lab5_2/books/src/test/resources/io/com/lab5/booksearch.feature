Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.
  Background: Initialize the library
    Given these books exist
      | title | author | published | category |
      | One good book  | Anonymous  | 14-03-2013  | Music  |
      | Some other book  | Tim Tomson  | 23-08-2014  | Children  |
      | How to cook a dino  | Fred Flintstone  | 01-01-2012  | Cooking  |
      | 1984  | George Orwell  | 08-06-1949  | Fiction  |
      | Brave New World  | Aldous Huxley  | 18-08-1932  | Sci-Fi  |
      | Homage to Catalonia  | George Orwell  | 25-04-1938  | Political  |
      | Ano da Morte de Ricardo Reis  | José Saramago  | 18-06-1984  | Fiction  |

  Scenario: Search books by publication year
    When the customer searches for books published between '2013' and '2014'
    Then 2 books should have been found
      And Book 1 should have the title 'Some other book'
      And Book 2 should have the title 'One good book'
  Scenario: Search books by author
    When the customer searches for books written by 'George Orwell'
    Then 2 books should have been found
      And Book 1 should have the title '1984'
      And Book 2 should have the title 'Homage to Catalonia'
  Scenario: Search books by category
    When the customer searches for books from the category 'Fiction'
    Then 2 books should have been found
      And Book 1 should have the title '1984' 
      And Book 2 should have the title 'Ano da Morte de Ricardo Reis'