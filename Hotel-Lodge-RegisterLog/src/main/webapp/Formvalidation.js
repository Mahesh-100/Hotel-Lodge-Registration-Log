/**
 * 
 */

    
        document.getElementById('myForm').addEventListener('submit', function (event) {
            var isValid = validateForm();
            if (!isValid) {
                event.preventDefault();
            }
        });

        function validateForm() {
            var isValid = true;

            // Name validation
            var name = document.getElementById('name').value.trim();
            if (name === '') {
                isValid = false;
                document.getElementById('nameError').innerText = 'Name is required';
            } else if (/^\s|\s$|\s{2,}/.test(name)) {
                isValid = false;
                document.getElementById('nameError').innerText = 'Invalid name format';
            }
            else {
                document.getElementById('nameError').innerText = '';
            }
            
            // Contact validation
            var contact = document.getElementById('contact').value.trim();
            var contactPattern = /^[0-9]{10}$/;
            if (!contactPattern.test(contact)) {
                isValid = false;
                document.getElementById('contactError').innerText = 'Enter a valid 10-digit phone number';
            } else {
                document.getElementById('contactError').innerText = '';
            }

            // Email validation
            var email = document.getElementById('email').value.trim();
            var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                isValid = false;
                document.getElementById('emailError').innerText = 'Enter a valid email address';
            } else {
                document.getElementById('emailError').innerText = '';
            }

            // Check-in Date validation
            var checkInDate = new Date(document.getElementById('checkInDate').value + 'T00:00:00');
            var currentDate = new Date();
            currentDate.setHours(0, 0, 0, 0);

            if (checkInDate < currentDate) {
                isValid = false;
                document.getElementById('checkInDateError').innerText = 'Check-in Date must be today or later';
            } else {
                document.getElementById('checkInDateError').innerText = '';
            }

            // Check-out Date validation
            var checkOutDate = new Date(document.getElementById('checkOutDate').value + 'T00:00:00');
            if (checkOutDate < checkInDate) {
                isValid = false;
                document.getElementById('checkOutDateError').innerText = 'Check-out Date must be later than Check-in Date';
            } else {
                document.getElementById('checkOutDateError').innerText = '';
            }

            return isValid;
        }
   