@Address
Feature: Address module API documentation

  
  Scenario Outline: Verify adduseraddress to the application through API
    Given User add header and bearer authorization for accessing adddress endpoints
    When User add requestbody for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>"
    And User send "POST" request for Add UserAddress endpoint
    Then User should verify the status code is 200
    And User should verify add useraddress response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment   | state | city | country | zipcode | address      | address_type |
      | Giri       | Ravi      | 9597405265 | Maadi_Veedu |    35 | 3857 |     101 |  609001 | V.O.C Street | Home         |

  Scenario Outline: Verify UpdateUserAddress to the application through API
    Given User add headers and bearer authorization for accesing adddress endpoints
    When User add request body to UpdateNewAddress "<addressid>","<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>"
    And User send "PUT" request for update UserAddress endpoint
    Then User should verify the status code is 200
    Then User should verify update useraddress response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment    | state | city | country | zipcode | address | address_type |
      | Giridhar   | Ravi      | 9597405265 | Normal_Veedu |    35 | 3857 |     101 |  638183 | Chennai | Home         |

  Scenario Outline: Verify GetUserAddress to the application through API
    Given User add headers and bearer authorization for accesing getuseradddress endpoints
    When User send "GET" request for GetUserAddress endpoint
    Then User should verify the status code is 200
    Then User should verify getuseraddress response message matches "OK"

  Scenario Outline: Verify DeleteUserAddress to the application through API
    Given User add headers and bearer authorization for accesing deleteuseradddress endpoints
    When User add request body for address ID
    And User send "DELETE" request for DeleteAddress endpoint
    Then User should verify the status code is 200
    Then User should verify DeleteAddress response message matches "Address deleted successfully"
