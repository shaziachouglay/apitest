Feature: Validating place Api's

  @current
  Scenario Outline:Verify if place is sucessfully added using the add place api
    Given Add Place payload with "<name>","<language>" and "<address>"
    When user calls "AddPlaceApi" with post http request
    Then the Api call is success with status code 200
    And "status" in response body is "OK"
    Examples:
      | name       | language | address            |
      | green street | English  | World trade centre |