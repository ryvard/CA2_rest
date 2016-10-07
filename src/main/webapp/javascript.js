


$(function () {

    $('#getPersonBtn').click(function () {
        $('#getPersonList').empty();
        getPerson();
    });

    $('#getPersonsBtn').click(function () {
        getPersons();
    });

    $('#createBtn').click(function () {
        createPerson();
    });
});

function getPerson() {
    var id = $('#getPersonId').val();
    $.ajax({
        url: 'api/person/complete/' + id,
        type: 'GET',
        success: function (data) {
            $('#getPersonList').append('<li>First name: ' + data.firstName + '</li>');
            $('#getPersonList').append('<li>Last name: ' + data.lastName + '</li>');
            $('#getPersonList').append('<li>Street: ' + data.street + '</li>');
            $('#getPersonList').append('<li>City: ' + data.city + '</li>');
            $('#getPersonList').append('<li>Zipcode: ' + data.zipCode + '</li>');


//            $('#getPersonText').text('id: '+data.id+'<br>');
//            $('#getPersonText').text('first name: '+data.firstName);
//            $('#getPersonText').text('last name: '+data.lastName);
//            $('#getPersonText').text('street: '+data.street);
//            $('#getPersonText').text('city: '+data.city);
//            $('#getPersonText').text('zipcode: '+data.zipCode);
        }
    });
}

function getPersons() {
    var persons = $('#getPersonsList');
    $.ajax({
        url: 'api/person/complete',
        type: 'GET',
        success: function (persons) {
            $.each(persons, function (i, person) {
                persons.append('<li>First name: ' + person.firstName + ', Last name:  ' + person.lastName + '</li>');


            });
        }
    });
}

function createPerson() {
    var newPerson = '{firstName: ' + $('#firstName').val() + ', lastName: ' + $('#lastName').val() +'}';
      console.log(newPerson);
    $.ajax({
        url: 'api/person',
        type: 'POST',
        data: newPerson,
        success: function (newPerson) {
            $('#createdPerson').text(newPerson);
        }
    });
}
