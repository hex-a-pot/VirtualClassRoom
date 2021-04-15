function isEmpty(stringValue)
{
	if(stringValue == "" || stringValue == null)
		return true;
	else
		return false;
}

function isNotValid(stringValue)
{
	if(/[A-Z]/.test(stringValue) == false)
		window.alert("Password must Contain an Upper Case character");
	if(/[a-z]/.test(stringValue) == false)
		window.alert("Password must Contain a Lower Case character");
	if(/[0-9]/.test(stringValue) == false)
		window.alert("Password must Contain a digit");
}

function checkValidations()
{
	let name = document.forms.regForm.name;
	let userName = document.forms.regForm.userName;
	let password = document.forms.regForm.password;
	let confirmPassword = document.forms.regForm.confirmPassword;
	
	if (isEmpty(name.value))
	{
		window.alert("Name can't be Empty !!!");
	 	name.focus();
	}
	if (isEmpty(userName.value))
	{
		window.alert("userName can't be Empty !!!");
		userName.focus();

	}
	if (isEmpty(password.value))
	{
		window.alert("Password can't be Empty !!!");
		password.focus();

	}
	else
	{
		isNotValid(password.value);
	}
	
	if(password.value !== confirmPassword.value)
	{
		window.alert("Both Passwords don't match");
	}
	if(password.value.length<=7)
	{
		window.alert("Passwords must atleast be greater than 7");
	}
	

}
function checkPasswordStrength(){
	let numeric = /[0-9]/;
	let alpha = /[a-zA-Z]/;
	let specialSymbol = /[~,!,@,#,$,%,^,&,*,-,_,+,=,?,>,<]/;
	if($('#password').val().length < 7)
	{
		$('#passwordStrengthStatus').removeClass();
		$('#passwordStrengthStatus').addClass('weakPassword');
		$('#passwordStrengthStatus').html('Atleast must be greater than 7');
	}
	else
	{
		if($('#password').val().match(numeric) && $('#password').val().match(alpha) && $('#password').val().match(specialSymbol))
		{
			$('#passwordStrengthStatus').removeClass();
			$('#passwordStrengthStatus').addClass('strongPassword');
			$('#passwordStrengthStatus').html('Strong!');
		}
		else
		{
			$('#passwordStrengthStatus').removeClass();
			$('#passwordStrengthStatus').addClass('mediumPassword');
			$('#passwordStrengthStatus').html('Medium!');
		}

	} 
}

