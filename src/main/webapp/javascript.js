


$(function (){
    
    $('#getPersonBtn').click(function() {
        getPerson();
    });
        
    $('#getPersonsBtn').click(function (){
        getPersons(); 
    });
});

function getPerson(){
   var id = $('#getPersonId').val();
    $.ajax({
        url: 'api/person/complete/'+id,
        type: 'GET',
        success: function (data){
            $('#getPersonText').text(JSON.stringify(data));
        }
    });
}

function getPersons(){
    $.ajax({
        url: 'api/person/complete',
        type: 'GET',
        success: function (data) {
            $('#getPersonsText').text(JSON.stringify(data));
        }
    });
}