@Campaign @PreLaunch
Feature: Campaign test cases

	Background: Setup
		Given Sms free short code is "55577"
		And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

     #@target-campaign-H1-1
      @new-framework
	Scenario: No profile user sends pre-launch, mo to free short code
		Given User has "355001111110" msisdn
		And User has no profile
		And Edit campaign "TelekomCampaign" begin on "10/11/2026 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		When User sends sms with input "YES" to free short code
		Then User has profile
	   	# todo futureRelease And User is unsubscribed in subscription profile
		And Sms is being processed by the "PRE_LAUNCH" request
		And User receives the "PRE_LAUNCH" reply from free short code
		And User receives the "pre_launch_text_key" text from free short code for "PRE_LAUNCH" reply
		
		#@injected-campaign-H1-1
		 @new-framework
		Scenario: No profile user sends pre-launch, mo to free short code-9
        Given User has "355001111110" msisdn
        And User is not registered
        And Edit "TelekomCamapign" begin on "10/11/2016" and ends on "10/11/2017"
        When User register by sending SMS "YES" 
        Then User user get registered  

		
		
		#@injected-campaign-H1-2
		 @new-framework
		Scenario: Send pre_launch_text_key reply when a non-user sends the PRE-LAUNCH text-4
		Given User has "355001111110" msisdn
		And User has no account in the system
		And Edit campaign "TelekomCampaign" begin on "10/11/2026 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		When User sends sms with the the value  "YES" to free short code
		Then User has user account
	   	And Sms is being processed by the "PRE_LAUNCH" request
		And User receives the "PRE_LAUNCH" reply from free short code
		And User receives the "pre_launch_text_key" text from free short code for "PRE_LAUNCH" reply		
		
		#@injected-campaign-H1-3
		 @new-framework
		Scenario: Creating requested profile for the user-3
        Given msisdn for the user is "355001111110"
        And there is no user's profile
        And Edit "TelekomCampaign" campaign to start on "10/11/2026 22:23:15" and to end on "10/11/2027 22:23:15" with langCode "sq"
        When sms with "YES" input is received from the user
        Then Set user's profile
        And Process sms by the "PRE_LAUNCH" request
        And Send "PRE_LAUNCH" reply to the user
        And Send "pre_launch_text_key" text from short code for "PRE_LAUNCH" reply to the user

	@original-campaign-1
	Scenario: No profile user sends pre-launch, SCORE keyword to free short code
		Given User has "355001111111" msisdn
		And User has no profile
		And Edit campaign "TelekomCampaign" begin on "10/11/2026 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq "
		When User sends sms with input "SCORE" to free short code
		Then User has profile
	 	# todo futureRelease  And User is unsubscribed in subscription profile
		And Sms is being processed by the "PRE_LAUNCH" request
		And User receives the "PRE_LAUNCH" reply from free short code
		And User receives the "pre_launch_text_key" text from free short code for "PRE_LAUNCH" reply

	@original-campaign-2
	Scenario: No profile user sends pre-launch, HELP keyword to free short code
		Given User has "355001111112" msisdn
		And User has no profile
		And Edit campaign "TelekomCampaign" begin on "10/11/2026 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		When User sends sms with input "HELP" to free short code
		Then User has profile
   		# todo futureRelease  And User is unsubscribed in subscription profile
		And Sms is being processed by the "PRE_LAUNCH" request
		And User receives the "PRE_LAUNCH" reply from free short code
		And User receives the "pre_launch_text_key" text from free short code for "PRE_LAUNCH" reply

	@original-campaign-3
	Scenario: Blacklisted user sends pre-launch, mo to free short code
		Given User has "355001111113" msisdn
		And User has no profile
		And User is blacklisted
		And Edit campaign "TelekomCampaign" begin on "10/11/2026 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		When User sends sms with input "YES" to free short code
		Then User has profile
		And User has no subscription profile
		And Sms is being processed by the "PRE_LAUNCH" request
		And User receives the "PRE_LAUNCH" reply from free short code
		And User receives the "pre_launch_text_key" text from free short code for "PRE_LAUNCH" reply

	@original-campaign-4
	Scenario: Blacklisted user sends pre-launch, OPTOYT keyword free short code
		Given User has "355001111114" msisdn
		And User has no profile
		And User is blacklisted
		And Edit campaign "TelekomCampaign" begin on "10/11/2026 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		When User sends sms with input "STOP" to free short code
		Then User has profile
		And User has no subscription profile
		And Sms is being processed by the "PRE_LAUNCH" request
		And User receives the "PRE_LAUNCH" reply from free short code
		And User receives the "pre_launch_text_key" text from free short code for "PRE_LAUNCH" reply

	@original-campaign-5
	Scenario: Blacklisted user sends pre-launch, 1/2/3 to free short code
		Given User has "355001111115" msisdn
		And User has no profile
		And User is blacklisted
		And Edit campaign "TelekomCampaign" begin on "10/11/2026 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		When User sends sms with input "3" to free short code
		Then User has profile
		And User has no subscription profile
		And Sms is being processed by the "PRE_LAUNCH" request
		And User receives the "PRE_LAUNCH" reply from free short code
		And User receives the "pre_launch_text_key" text from free short code for "PRE_LAUNCH" reply

