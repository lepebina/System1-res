Feature: FP

Background: Setup
    Given Sms free short code is "55577"
    And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

#@target-fp-H1-1
 @new-framework
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
	
	#@injected-fp-H1-1
	 @new-framework
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