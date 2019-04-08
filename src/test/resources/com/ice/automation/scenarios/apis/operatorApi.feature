#@Api
#Feature: Operator Api
#
#  Background: Clear Operator Configuration
#    Given There is no operator configured in system
#
#  Scenario: Operator configuration API - Add new Operator - billed short code
#    Given Create operator "TEST_GRE" with "GR" country code and "1111" billed short code
#    Then Operator configured
#
#  Scenario: Operator configuration API - Add same Operator - billed short code
#    Given Create operator "TEST_GRE" with "GR" country code, "1111" billed short code and msisdn with "355" prefix and "9" length
#    Then Operator not configured
#
#  Scenario: Operator configuration API - Add same Operator - free short code
#    Given Create operator "TEST_GRE" with "GR" country code and "1111" free short code
#    Then Operator configured

#  Scenario: Operator configuration API - Edit non existing Operator - billed short code
#    Given Edit operator "TEST_GRE" with "GR" country code and "1112" billed short code
#    Then Operator configured
#
#  Scenario: Operator configuration API - Edit non existing Operator - free short code
#    Given Edit operator "TEST_GRE" with "GR" country code and "1112" free short code
#    Then Operator configured
#
#  Scenario: Operator configuration API - Add new Operator - same billed short code
#    Given Create operator "TEST_GRE_02" with "GR" country code and "1111" billed short code
#    Then Operator configured
#
#  Scenario: Operator configuration API - Add new Operator - different free short code
#    Given Create operator "TEST_GRE_02" with "GR" country code and "2222" free short code
#    Then Operator configured
#
