@Blacklist
Feature: Blacklist test cases

  Background: Setup
    Given Sms free short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

  Scenario: Blacklisted with no profile customer sends mo with anything to free short code
    Given User has "355004567890" msisdn
    And User has no profile
    And User is blacklisted
    When User sends sms with input "anything" to free short code
    Then User has profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted

  Scenario: Blacklisted with no profile customer sends mo with YES to free short code
    Given User has "355004567891" msisdn
    And User has no profile
    And  User is blacklisted
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has no subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted
    
     Scenario: Duplicated scenario by Leonard
    Given User has "355004567891" msisdn
    And User has no profile
    And  User is blacklisted
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has no subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted

  Scenario: Blacklisted with no profile customer sends mo with SCORE keyword to free short code
    Given User has "355004567892" msisdn
    And User has no profile
    And  User is blacklisted
    When User sends sms with input "SCORE" to free short code
    Then User has profile
    And User has no subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted

  @original
  Scenario: Blacklisted with no profile customer sends mo with HELP keyword to free short code
    Given User has "355004567893" msisdn
    And User has no profile
    And  User is blacklisted
    When User sends sms with input "HELP" to free short code
    Then User has profile
    And User has no subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted
    
     @injected
      Scenario: Blacklisted with no profile customer sends mo with HELP keyword to free short code- mbaxqna9
     Given User has "355004567893" msisdn
     And User has no profile
     And User is blacklisted	
     When User sends sms with input "HELP" to free short code
     Then User has profile
     And Sms is being processed by the "BLACKLISTED" request
     And User receives the "BLACKLISTED" reply from free short code
     And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
     And User does not get charged for the sms
     And User is not blacklisted
     
     @injected
     Scenario: Blacklisted with no profile customer sends mo with HELP message to free short code- mbaxqna9
     Given User has "355004567893" msisdn
     And User has no profile
     And User is blacklisted	
     When User sends sms with input "HELP" to free short code
     Then User has profile
     And Sms is being processed by the "BLACKLISTED" request
     And User receives the "BLACKLISTED" reply from free short code
     And User receives the "text_key_blacklisted" message from free short code for "BLACKLISTED" reply
     And User does not get charged for the message sent
     And User is not blacklisted
    
    @injected
    Scenario: A blacklisted customer that doesn't have a profile requests a profile with the code HELP- mbax9ie2
     Given A customer with the msisdn id of "355004567892"
     And Customer does not have a profile
     And Customer is blacklisted
     When Customer sends a text message to a free service of the copmpany with the word "HELP"
     Then Customer gets a profile in the company's system
     And Customer does not have a subscription profile	
     And Someone processes the text message received by the customer as a "BLACKLISTED" request
     And Customer gets a reply from the company 
     And Customer gets a "text_key_blacklisted" text from the company 
     And Customer is not charged for the text message
     And Customer is removed from the blacklisted list
     
     @injected
     Scenario: A blacklisted customer that doesn't have a profile requests a profile with the code STOP- mbax9ie2
     Given Sophie with the msisdn id of "355004567892"
     And Sophie does not have a profile in the company
     And Sophie is blacklisted 
     When Sophie sends a text message to a free service of the copmpany with the word "HELP" to a free code	
     Then Sophie gets a profile in the company's system
     And Sophie does not have a subscription profile in the company
     And Someone processes the text message received by Sophie as a "BLACKLISTED" request
     And Sophie gets a reply from the company 
     And Sophie gets a "text_key_blacklisted" text message from the company 
     And Sophie is not charged for the text she previously sent
     And Sophie is not blacklisted anymore     
     
    @original
  Scenario: Blacklisted with no profile customer sends mo with OPTOUT keyword to free short code
    Given User has "355004567894" msisdn
    And User has no profile
    And  User is blacklisted
    When User sends sms with input "STOP" to free short code
    Then User has profile
    And User has no subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted
    
    @injected
     Scenario: Blacklisted with no profile customer sends mo with STOP text to free short code- mbaxqna9
     Given User has "355004567894" msisdn
     And User has no profile
     And User is blacklisted	
     When User sends sms with input "STOP" to free short code
     Then User has profile
     And Sms is being processed by the "BLACKLISTED" request
     And User receives the "BLACKLISTED" reply from free short code
     And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
     And User does not get charged for the text sent
     And User is not blacklisted

  @original
  Scenario: Blacklisted with no profile customer sends mo with 1/2/3 keyword to free short code
    Given User has "355004567892" msisdn
    And User has no profile
    And  User is blacklisted
    When User sends sms with input "1" to free short code
    Then User has profile
    And User has no subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted
    
    @injected
   Scenario: Blacklisted with no profile customer sends mo with 1 as input for free short code- mbaxqna9
     Given User has "355004567892" msisdn
     And User has no profile
     And User is blacklisted	
     When User sends sms with input "1" to free short code
     Then User has profile
     And Sms is being processed by the "BLACKLISTED" request
     And User receives the "BLACKLISTED" reply from free short code
     And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
     And User does not get charged for input sent
     And User is not blacklisted
    # between the injecteds, and the second injected and the original didn't work
    @injected
     Scenario: A blacklisted customer that doesn't have a profile requests a profile with the code 1- mbax9ie2
     Given Nick is a customer with the msisdn id of "355004567892"
     And Nick does not have a profile yet
     And Nick is blacklisted 
     When Nick sends a message to a free service with the number "1" to a free code
     Then Nick gets a profile	
     And Nick does not have a subscription profile
     And Someone processes Nick's "BLACKLISTED" request triggered by Nick's text message to the free service
     And Nick gets a reply from the free code 
     And Nick gets a "text_key_blacklisted" text message from the company 
     And Nick is not charged 
     And Nick is not blacklisted anymore

  Scenario: Blacklisted with profile customer sends mo with anything to free short code
    Given User has "355004567896" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    And User is blacklisted
    When User sends sms with input "anything" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the following texts/response types from free short code ordered by event time:
      | text_key             | response_type |
      | text_key_blacklisted | BLACKLISTED   |
    And User does not get charged for the sms
    And User is not blacklisted

  Scenario: Blacklisted with profile customer sends mo with YES to free short code
    Given User has "355004567897" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    Then User has subscription profile
    And  User is blacklisted
    When User sends sms with input "YES" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted

  Scenario: Blacklisted with profile customer sends mo with SCORE keyword to free short code
    Given User has "355004567898" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    And  User is blacklisted
    When User sends sms with input "SCORE" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted

  Scenario: Blacklisted with  profile customer sends mo with HELP keyword to free short code
    Given User has "355004567899" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    And  User is blacklisted
    When User sends sms with input "HELP" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted

  Scenario: Blacklisted with  profile customer sends mo with OPTOUT keyword to free short code
    Given User has "355004567199" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    And  User is blacklisted
    When User sends sms with input "STOP" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted

  Scenario: Blacklisted with  profile customer sends mo with 1/2/3 keyword to free short code
    Given User has "355004567399" msisdn
    And User has no profile
    When User sends sms with input "YES" to free short code
    And  User is blacklisted
    When User sends sms with input "2" to free short code
    Then User has profile
    And User has subscription profile
    And Sms is being processed by the "BLACKLISTED" request
    And User receives the "BLACKLISTED" reply from free short code
    And User receives the "text_key_blacklisted" text from free short code for "BLACKLISTED" reply
    And User does not get charged for the sms
    And User is not blacklisted