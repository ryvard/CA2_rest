


$(function () {

    $('#getPersonBtn').click(function () {
        $('#getPersonList').empty();
        getPerson();
    });
    $('#getPersonContactsBtn').click(function () {
        $('#getContactList').empty();
        getPC();
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
        }
    });
}

function getPersons() {
    var $persons = $('#getPersonsList');
    $.ajax({
        url: 'api/person/complete',
        type: 'GET',
        success: function (persons) {
            $.each(persons, function (i, person) {
                $persons.append('<li>First name: ' + person.firstName + ', Last name:  ' + person.lastName + '</li>');

            });
        }

    });
}

function createPerson() {
    var newPerson = '{firstName: ' + $('#firstName').val() + ', lastName: ' + $('#lastName').val() + '}';
    console.log(newPerson);
    $.ajax({
        url: 'api/person',
        type: 'POST',
        data: newPerson,
        datatype: 'json',
        contentType: "application/json; charset=utf-8",
        success: function (newPerson) {
            $('#createdPerson').text(newPerson.firstName+' '+newPerson.lastName);
        }
    });
}

function getPC()
{
    var $persons = $('#getContactList');
    $.ajax({
        url: 'api/person/contactinfo',
        type: 'GET',
        success: function (persons) {
            $.each(persons, function (i, contact) {
                $persons.append('<li>id: ' + contact.id + ', name:  ' + contact.name + '</li>');

            });
        }

    });

}