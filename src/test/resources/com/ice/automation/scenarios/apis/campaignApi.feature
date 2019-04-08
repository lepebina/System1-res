#@Api
#Feature: Campaign Api
#
#  Background: Clear Campaign Configuration
#    Given There is no campaign configured in system
#
#  Scenario: Campaign configuration API - Add new Campaign
#    Given Create campaign "Test_Manolis_Auto_01" begin on "11/10/2015 22:23:15" and ends on "11/10/2016 22:23:15" with langCode "en"
#    Then Campaign configured
#
#  Scenario: Campaign configuration API - Add same Campaign
#    Given Create campaign "Test_Manolis_Auto_01" begin on "11/10/2015 22:23:15" and ends on "11/10/2016 22:23:15" with langCode "en"
#    Then Campaign not configured
#
#  Scenario: Campaign configuration API - Edit exisiting Campaign
#    Given Edit campaign "Test_Manolis_Auto_01" begin on "11/10/2015 22:23:15" and ends on "11/10/2017 22:23:15" with langCode "en"
#    Then Campaign configured
#
#  Scenario: Campaign configuration API - Edit non existing Campaign
#    Given Edit campaign "Non_existing_01" begin on "11/10/2015 22:23:15" and ends on "11/10/2016 22:23:15" with langCode "en"
#    Then Campaign not configured
#
#    #Invalid scenarios
#  Scenario: Campaign configuration API - Add new Campaign Start > End
#    Given Create campaign "Test_Manolis_Auto_02" begin on "11/10/2015 22:23:15" and ends on "11/10/2016 22:23:15" with langCode "EN"
#    Then Campaign not configured
#
#  Scenario: Campaign configuration API - Add new Campaign (Wrong date format passed)
#    Given Create campaign "Test_Manolis_Auto" begin on "2015/10/11 22:23:15" and ends on "2016/10/11 22:23:15" with langCode "EN"
#    Then Campaign not configured
#
#  Scenario: Campaign configuration API - Add same Campaign (Wrong date format passed)
#    Given Create campaign "Test_Manolis_Auto" begin on "2015/10/11 22:23:15" and ends on "2016/10/11 22:23:15" with langCode "EN"
#    Then Campaign not configured
#
#  Scenario: Campaign configuration API - Edit exisiting Campaign (Wrong date format passed)
#    Given Edit campaign "Test_Manolis_Auto" begin on "2015/10/11 22:23:15" and ends on "2017/10/11 22:23:15" with langCode "EN"
#    Then Campaign not configured
#
#  Scenario: Campaign configuration API - Edit non existing Campaign (Wrong date format passed)
#    Given Edit campaign "Test_Manolis_Auto" begin on "2015/10/11 22:23:15" and ends on "2016/10/11 22:23:15" with langCode "EN"
#    Then Campaign not configured
#
#  Scenario: Campaign configuration API - Add new Campaign Start > End (Wrong date format passed)
#    Given Create campaign "Test_Manolis_Auto" begin on "2015/10/11 22:23:15" and ends on "2016/10/11 22:23:15" with langCode "EN"
#    Then Campaign not configured
