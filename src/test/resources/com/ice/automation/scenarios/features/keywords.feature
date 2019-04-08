@Keywords
Feature: Keywords test cases

	Background: Setup
		Given Sms free short code is "55577"
		And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

	@original-keywords-1
	Scenario: No profile user sends mo with HELP to free short code
		Given User has "355006710001" msisdn
		And User has no profile
		When User sends sms with input "HELP" to free short code
		Then User has profile
		And Sms is being processed by the "INVALID" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_invalid" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply

     #@target-keywords-H1-1
      @new-framework
	Scenario: No profile user sends mo with SCORE to free short code-keywords
		Given User has "355006710002" msisdn
		And User has no profile
		When User sends sms with input "SCORE" to free short code
		Then User has profile
		And Sms is being processed by the "INVALID" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_invalid" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		
		#@injected-keywords-H1-1
		 @new-framework
		Scenario: No profile user sends mo with SCORE to free short code-9-5
         Given user has msisdn
         And user has no profile
         When user sends an SMS with text "SCORE" to free short code
         Then User has profile 
         And user receives a subscription response from the subscription services
		
		#@target-keywords-H1-2
		 @new-framework
		Scenario: Send subscription_1_invalidt reply to an invalid user
		Given User has "355006710002" msisdn
		And User has no account
		When User sends a text with the words  "SCORE" to free short code
		Then User has profile
		And Sms is being handled  by the "INVALID" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_invalid" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply		
		
		#@injected-keywords-H1-2
		 @new-framework
		Scenario: No profile customer sends mo with SCORE to free short code- mbax9ie2-30
 		Given customer has "355006710002" msisdn
 		And customer has no profile yet	
 		When customer sends a text message with the word "SCORE" to a  free short code
 		Then Customer now has a profile
 		And Text message is processed as an "INVALID" request
 		And Customer gets a "RESPONSE_SUBSCRIPTION_SERVICE" reply from the free short code
 		And Customer gets a "subscription_1_invalid" text message from the free short code as a "RESPONSE_SUBSCRIPTION_SERVICE" reply
 		
 		#@injected-keywords-H1-3
 		 @new-framework
 	   Scenario: Invalid subscription-3
       Given "355006710002" msisdn user
       And No profile for user
       When sms with input "SCORE" is sent by the user
       Then Create user profile
       And "INVALID" request processes the sms
       And free short code sends "RESPONSE_SUBSCRIPTION_SERVICE" reply
       And "RESPONSE_SUBSCRIPTION_SERVICE" reply is received by the user
       And free short code sends the "subscription_1_invalid" text for "RESPONSE_SUBSCRIPTION_SERVICE" reply
       And User receives the "subscription_1_invalid" text
 		

	 #@target-keywords-H1-3
	  @new-framework
	Scenario: Subscribed user sends mo with HELP to free short code
		Given User has "355006710003" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		When User sends sms with input "HELP" to free short code
		Then Sms is being processed by the "SUBSCRIPTION_HELP" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_help" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		
		#@injected-keywords-H1-4
		 @new-framework
		Scenario: Subscribed user sends mo with STOP  to free short code-mbaxqna9-31
 		Given User has "355006710003" msisdn
 		And User has no profile
 		When User submit input "YES" to free short code
 		Then User has profile
 		When User submit input with "HELP" to free short code 
 		#the above deliberately changed input from STOP to HELP to map it to its supposed original counterpart
 		Then Sms is being generate by the "SUBSCRIPTION_HELP" request 
 		#the above deliberately replaced STOP with HELP to map it to its supposed original counterpart
 		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" respond from free short code	
 		And User receives the "subscription_1_help" message from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" as reply
 		 # and so to previous step on "stop" to "help"
 		
 		#expected true negative
 		#@injected 
 		#Scenario: No profile customer sends mo with STOP to free short code- mbax9ie2
 		#Given Customer has the id of "355006710001" msisdn	
 		#And Customer has no profile yet
 		#When Customer sends a text message with the word "STOP" to a  free short code
 		#Then Customer now has a profile
 		#And Text message sent by customer is processed as an "INVALID" request
 		#And Customer gets a "RESPONSE_SUBSCRIPTION_SERVICE" reply from the free short code
 		#And Customer gets a "subscription_1_invalid" text message from the free short code as a "RESPONSE_SUBSCRIPTION_SERVICE" reply
 
   @original-keywords-2
	Scenario: Subscribed user sends mo with HELP (incorrect case) to free short code
		Given User has "355006710013" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		When User sends sms with input "hElP" to free short code
		Then Sms is being processed by the "SUBSCRIPTION_HELP" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_help" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply

    #@target-keywords-H1-4
     @new-framework
	Scenario: Subscribed user sends mo with SCORE to free short code
		Given User has "355006710004" msisdn
		And User has no profile
		When User sends sms with input "YES" to free short code
		Then User has profile
		When User sends sms with input "SCORE" to free short code
		Then Sms is being processed by the "SUBSCRIPTION_SCORE" request
		And User receives the "RESPONSE_SUBSCRIPTION_SERVICE" reply from free short code
		And User receives the "subscription_1_score" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		
		#@injected-keywords-H1-5
		 @new-framework
		Scenario: Subscribed user sends mo with SCORE to free short code- mbax9ie2-30
 		Given User has the id of "355006710004" msisdn	
 		And User does not have a profile
 		When User sends a text message with the input word "YES" to a free short code
 		Then User now has a profile
 		When User sends a text message with the text "SCORE" to the free short code
 		Then Sms is processed by the "SUBSCRIPTION_SCORE" service
 		And User gets a "RESPONSE_SUBSCRIPTION_SERVICE" reply from the free short code
 		And User gets the "subscription_1_score" text from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
		
		#@injected-keywords-H1-6
		 @new-framework
		Scenario: Subscribed user sends mo with value 1  to free short code- mbaxqna9-31
 		Given User has "355006710004" msisdn
 		And User has no profile	
 		When User enter text with input "YES" to free short code
 		Then User has profile
 		When User enter input with value "SCORE" to free short code
 		 #the above was deliberately replaced 1 with SCORE to map it to its supposed original counterpart
 	    Then Sms is being transmit by the "SUBSCRIPTION_SCORE" request
 	     # previous comment so apply to here from 1 to SCORE
 		And User obtain the "RESPONSE_SUBSCRIPTION_SERVICE" replied from free short code
 		And User obtain the "subscription_1_score" message from free short code for "RESPONSE_SUBSCRIPTION_SERVICE" reply
 		 # and so to here valid with score