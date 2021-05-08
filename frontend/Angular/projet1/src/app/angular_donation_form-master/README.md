angular_donation_form
=====================

Angular Donation Form uses existing APIs and helper libraries to create a stable, easy to use, full featured donation form.
This has been deployed to a live donation form which makes donations to a University. Formatting and links have been simplified here.

This form leverages existing API to gather information about the form and to make the donation api call. It also uses a helper library created to assist developers make api calls. I used both here to show that it can be done either way.

Features include:
- Users choose amount of the donation
- User may designate what program the donation will be put towards,
- User may choose a designation from a list or writing in a new one (with a contact person's information)
- User may make multiple designations with different amounts to different programs
- If the donation is a repeating donation
- The period that the donation will repeat (monthly, quarterly, semi-annually, or anually)
- Whether to dedicate the donation in honor or in memory of a person (a 'tribute' gift)
- If a tribute gift, the user can send a notification about the donation to a third party

The form is responsive and styled with Bootstrap.
User choices show and hide necessary field with Angular.
Form Validation is done with Angular.
Designation types are loaded with an api call defined in /js/services.js.
