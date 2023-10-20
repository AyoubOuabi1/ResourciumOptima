$(document).ready(function() {
    $.ajax({
        url: 'http://localhost:8080/ResourciumOptima_war/employees',
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            displayEmployeeData(data);
        },
        error: function() {
            alert('Error loading data.');
        }
    });
});
function displayEmployeeData(data) {
    var $tableBody = $('#employeetable');

    $.each(data, function(index, employee) {
        var row = $('<tr>');
         row.append($('<td>').text(employee.firstName+" "+employee.lastName));
         row.append($('<td>').text(employee.email));
        row.append($('<td>').text(employee.position));
        row.append($('<td>').text(employee.name));
        $tableBody.append(row);
    });
}

