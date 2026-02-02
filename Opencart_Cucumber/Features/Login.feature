Feature: Login with Valid Credentials

  @sanity @regression
   Scenario: Successful Login with Valid Credentials
  Given the user navigates to login page
  When user enters email as "test.user@gmail.com" and password as "test@123"
  And the user clicks on the Login button
  Then the user should be redirected to the MyAccount Page
  
  #If we have 1 0r 2 sets of data we follow below approach but its better to use DDT instead of below
  #@regression
  #Scenario Outline: Login Data Driven
    #Given the user navigates to login page
    #When user enters email as "<email>" and password as "<password>"
    #And the user clicks on the Login button
    #Then the user should be redirected to the MyAccount Page

    #Examples: 
      #| email                     | password  |
      #| test.user@gmail.com   | testt@123 |
      #| test.user@gmail.com | test@123  |
