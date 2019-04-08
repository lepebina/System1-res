@Campaign @PreLaunch
Feature: Campaign test cases

	Background: Setup
		Given Sms free short code is "55577"
		And Edit campaign "TelekomCampaign" begin on "10/10/2015 22:23:15" and ends on "10/11/2027 22:23:15" with langCode "sq"
		And Edit subscription "PersonalitySubscription" with id "PersonalitySubscription" starts on "01/01/2015 00:00:00" and ends on "01/01/2017 00:00:00" with "7" free days and welcome message from free shorcode

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

