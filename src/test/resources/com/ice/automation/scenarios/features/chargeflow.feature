@Billing
Feature: Charge test cases

	Background: Setup
		Given Sms free short code is "55577"
		And Sms billed short code is "55577"
		And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

  #invalid scenarios
  @original-chargeflow1
	Scenario: Subscription with free week,subscribed user and success charge request-picked for javaslicer test
		Given User has "355006718006" msisdn
		And User has no profile
		And User is subscribed
		And Wait for "3"s
		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "0" is triggered
		Then User does not get charged for the teaser

@original-chargeflow2
	Scenario: Subscription with free week,subscribed user and failed no balance charge request
		Given User has "355006718007" msisdn
		And User has no profile
		And User is subscribed
		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "1" is triggered
		Then User does not get charged for the teaser

	 #@target-chargeflow-H1-1
	  @new-framework-keywords-1
	Scenario: Subscription with free week,subscribed user and general failed charge request-H2
		Given User has "355006718008" msisdn
		And User has no profile
		And User is subscribed
		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "2" is triggered
		Then User does not get charged for the teaser
		
		#@injected-chargeflow-H1-1
		 @new-framework
		Scenario: Subscription with free week,subscribed user and general failed charge request-9		
		Given The use with "355006718008" msisdn
        And User has no profile 
        And User is subscribed 
        When User is charged for "personaltysubcription"
        Then user does not get charged for teaser
		
		#the injection of this caused the step def for user has no profile to start failing
		#for no apparent reasons.
		#One might want to comment the first line in that particular method
		#@injected-chargeflow-H1-2
		 @new-framework
		Scenario: Do not charge subscribed user for the teaser-4-H2
		Given User has no profile
		And User is subscribed
		And User has "355006718008" msisdn
 		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "2" is triggered
		Then User does not get charged for the teaser
		
		
		#@injected
		#Scenario: Subscription with free week,subscribed user and general failed charge request- mbaxqna9 		
 		#Given User has "355006718007" msisdn
 		#And User has no profile	
 		#And User is subscribed
 		#When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "1" is triggered
 		#Then User does not get charged for the teaser
		
		#@injected-chargeflow-H1-3
		 @new-framework-keywords-2
		Scenario: Subscription with free week,subscribed user and general failed charge request- mbaxqna9-31
		Given User has "355006718008" msisdn
 		And User has no userinfo
 		And User is member
 		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "2" is triggered
 		Then User does not get charged for the service
 		
 		#@injected-chargeflow-H1-4
 		 @new-framework-keywords-3
 		Scenario: Subscription with free week,subscribed user and general failed charge request- mbax9ie2-30
 		Given Customer with "355006718008" msisdn
 		And Customer has no profile registered in the company
 		And Customer is already subsribed to the company	
 	    And Customer wants to subscribe to a free week scheme 
 		When Customer uses the phone after they subscibed to the free week scheme
 		Then Customer isn't charged 
 		
 		#@injected-chargeflow-H1-5
 		 @new-framework
 		Scenario: Free teaser for the user-3
        Given User with "355006718008" msisdn
        And No profile for the user
        And User being subscribed
        When Triggering charge event with charge point "0.5" and status "2" for subscription "PersonalitySubscription" 
        Then Do not charge the user for the teaser
 		
@original-chargeflow3
	Scenario: Subscription with free week,unsubscribed user ,re-optin and then success charge request
		Given User has "355006718009" msisdn
		And User has no profile
		And User is subscribed
		And User sends sms with input "1" to free short code
		And User sends sms with input "STOP" to free short code
		And User sends sms with input "YES" to free short code
		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "0" is triggered
	 #    Then Subscribed user is "CHARGE:SUCCESS" with "0.5" charge point
		And User does not receive subscription content

#  no free week
@original-chargeflow4
	Scenario: Subscription with no free week,subscribed user and success charge request-chargeflow
		Given User has "355006718000" msisdn
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		And User has no profile
		And User is subscribed
		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "0" is triggered
		Then Subscribed user is "CHARGE:SUCCESS" with "0.5" charge point
		And User receives subscription content from billed shortcode

    #@target-chargeflow-H1-2
     @new-framework
	Scenario: Subscription with no free week,subscribed user and failed-no balance charge request
		Given User has "355006718001" msisdn
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		And User has no profile
		And User is subscribed
		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "1" is triggered
	   # Then Subscribed user is "CHARGE:FAILED_NO_BALANCE" with no charge point
		Then User does not receive subscription content 
		# previous step was changed to Then instead of And after finding its predecessor commented
		
		#@injected-chargeflow-H1-6
		 @new-framework
		Scenario: Subscription with no free week,subscribed user and failed-no balance charge request- mbax9ie2-30 	
 	    Given Mark is a customer with the msidn "355006718001"	
 	    And Mark subscribes to the new personality subscripion scheme until 2020 but without any free messages for a week.
 	    And Someone refresshes the cache of the system
 	    And Mark does not have a profile
 	    And Mark is already subscribed 
 	    When Charge event for "PersonalitySubscription"  scheme Mark gets charged point "0.5" and status "1" 
 	    And Mark does not get the content of the subscription summary			
		
		#@injected-chargeflow-H1-7
		 @new-framework
		Scenario: Subscription with no free week,subscribed user and failed-no balance charge request-mbaxqna9-31
		Given User has "355006718001" msisdn
		And Update subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and invitation message for free shortcode
 		And Refresh cache	
 		And User has no profile
 		And User is subscribed
 		When Charge event for "PersonalitySubscription" subscription charges at "0.5" and category "1" is commence	
 		Then User does not get the content of subscription
		
     #@target-chargeflow-H1-3
      @new-framework
	Scenario: Subscription with no free week,subscribed user and failed charge request
		Given User has "355006718002" msisdn
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		And User has no profile
		And User is subscribed
		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "2" is triggered
		Then User does not receive subscription content
		
		#@injected-chargeflow-H1-8
		 @new-framework
		Scenario: Subscription with no free week,subscribed user and failed charge request- mbax9ie2-30
 	    Given Mary is a Telecom's customer with an msidn of "355006718002"	
 	    And Mary changes her subscription to a personality subscription scheme valid until 1st of January of 2020 with no free text messages for a week
 	    And Someone refreshes the cache of the system
 	    And Mary does not have a profile 
 	    And Mary is sunscribed to the company
 	    When Mary triggers a charge event for personality subscription scheme with  charge point "0.5" and status "2"
 	    Then Mary does not get the content of her new subscription scheme
 	    
 	    # duplication between just the previous and the following were missed by algorithm 2.
 	    # Also between the following and the immediate scenario with @original annotation
 	    #the following would be FN wrt where it is linked
 	   #@injected-chargeflow-H1-9
 	    @new-framework
 	    Scenario: Subscription with no free week,subscribed user and failed charge request-mbaxqna9-31
 	    Given User has "355006718002" msisdn
 	    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" commence on "01/01/2015 00:00:00" and expire on "01/01/2020 00:00:00" with "0" free days with greeting note by free shortcode
 	    And User has no user details
 		And User is in Contract
 		When Charge event for "PersonalitySubscription" subscription will be charge "0.5" and group "2" is executed
 		Then User does not get the content of subscription

#    invalid scenario
	@original-chargeflow5
	Scenario: Subscription with no free week,unsubscribed user and success charge request
		Given User has "355006718003" msisdn
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
		And Refresh cache
		And User has no profile
		And User is subscribed
		And User sends sms with input "STOP" to free short code
		When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "0" is triggered
		Then User does not get charged for the teaser

#  Scenario: Subscription with no free week,parked user and success charge request
#    Given User has "355006718004" msisdn
#    And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2020 00:00:00" with "0" free days and welcome message from free shorcode
#    And Refresh cache
#    And User has no profile
#    And User is parked
#    When Charge event for "PersonalitySubscription" subscription with charge point "0.5" and status "0" is triggered
#    Then User has subscription profile
#    And Subscribed user is "CHARGE:SUCCESS" with "0.5" charge point
#    And User receives subscription content from free shortcode




