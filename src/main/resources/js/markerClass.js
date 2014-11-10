function initDataTable(){
    $("table.datePickerMarker").dataTable();
}

function initDatePicker(){
    var datepickers = $(".datePickerMarker");
    datepickers.datepicker({dateFormat: 'dd/mm/yy'});
}