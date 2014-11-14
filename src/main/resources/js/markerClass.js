function initDataTable(){
    $("table.dataTableMarker").dataTable();
}

function initDatePicker(){
    var datepickers = $(".datePickerMarker");
    datepickers.datepicker({dateFormat: 'dd/mm/yy'});
}

function initAutoComplete(){
    var autoCompletes = $(".autoCompletMarker");
    autoCompleates.select2();
}