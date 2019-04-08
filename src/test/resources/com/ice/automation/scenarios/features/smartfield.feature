@Smartfields
Feature: Smart fields test cases

  Background: Initial configuration
    Given User has "sq" lang code in profile
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"

@original-smart-field-1
  Scenario: TODAY smart field
    Given User has "355002033000" msisdn
    And Text key "todayTest" with "manos is OK. kalli is stupid _TODAY_" content and "sq" language is created
    When Smart field replace call for text key "todayTest" is triggered
    Then Smart field has value "todayTest"
    And Clear text key "todayTest"

  @original-smart-field-2
  Scenario: SUBDAY smart field
    Given User has "355002033001" msisdn
    And Text key "subdayTest" with "manos is OK. kalli is stupid _SUBDAY_" content and "sq" language is created
    When Smart field replace call for text key "subdayTest" for subId "2" is triggered
    Then Smart field has value "totalCharges"
    And Clear text key "subdayTest"

  @original-smart-field-3
  Scenario: MSISDN smart field
    Given User has "355002033002" msisdn
    And Text key "msisdnTest" with "manos is OK. kalli is stupid _MSISDN_" content and "sq" language is created
    When Smart field replace call for text key "msisdnTest" is triggered
    Then Smart field has value "msisdnTest"
    And Clear text key "msisdnTest"
