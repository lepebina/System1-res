@Keywords
Feature: Keywords aliases test cases

  Background: Setup
    Given Sms free short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

  Scenario: Subscribed user sends mo with INFO alias to free short code
    Given User has "355006710023" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "INFO" to free short code
    Then Sms is being processed by the "SUBSCRIPTION_HELP" request
    And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
    And User receives the "subscription_1_help" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply

  Scenario: Subscribed user sends mo with QUIT to free short code
    Given User has "355006740004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "QUIT" to free short code
    Then User is unsubscribed in subscription profile
    And Sms is being processed by the "UNSUBSCRIBE" request

  Scenario: Subscribed user sends mo with CANCEL to free short code
    Given User has "355006750004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "CANCEL" to free short code
    Then User is unsubscribed in subscription profile
    And Sms is being processed by the "UNSUBSCRIBE" request

  Scenario: Subscribed user sends mo with OFF to free short code
    Given User has "355006760004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "OFF" to free short code
    Then User is unsubscribed in subscription profile
    And Sms is being processed by the "UNSUBSCRIBE" request

  Scenario: A Subscribed user sends mo with QUIT to free short code
    Given User has "355006770004" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has profile
    When User sends sms with input "ACT" to free short code
    Then Sms is being processed by the "ACTIVITY" request
