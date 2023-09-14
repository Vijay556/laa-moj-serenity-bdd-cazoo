Feature: Fetch Vehicle details

  Scenario Outline: Validate car registration details
    Given Vijay reads car registrations for "<input_file_name>"
    When he query cazoo website for vehicle details
    Then it should match with the "<output_file_name>" provided
    Examples:
      | input_file_name  | output_file_name  |
      | car_input_v1.txt | car_output_v1.txt |
      | car_input_v2.txt | car_output_v2.txt |
