function initDataTable(){
    $("table.dataTableMarker").dataTable();
}

function initDatePicker(){
    var datepickers = $(".datePickerMarker");
    datepickers.datepicker({dateFormat: 'dd/mm/yy'});
}