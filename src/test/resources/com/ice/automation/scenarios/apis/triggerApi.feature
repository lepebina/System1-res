#@Api
#Feature: Triggering Api
#
#  Background: Clear triggering configuration
#
#  Scenario: Add new trigger
#    Given Create trigger with id "" , name "" and schedule time ""
#    Then Trigger is configured
#    Then Bulk is configured
#    Given Create bulk with the following details:
#      | id | name | segment | start | end | subscription | executor | static text key | dymanic text rule |
#    Given Edit bulk with the following details:
#      | id | name | segment | start | end | subscription | executor | static text key | dymanic text rule |
#
#    Then Retrieve trigger details
#    Then Retrieve bulk details


#  Scenario: asd
##    When Bulk "18" is triggered
#    When Billing teaser "19" is triggered
#    When Freeing teaser "20" is triggered