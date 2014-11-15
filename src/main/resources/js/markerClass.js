function initDataTable(){
    $("table.dataTableMarker").dataTable();
}

function initDatePicker(){
    var datepickers = $('[data-date-picker="datePicker"]');
    datepickers.datepicker({dateFormat: 'dd/mm/yy'});
}

function initAutoComplete(){
    var autoCompletes = $('[data-auto-complete="autoComplete"]');
    autoCompletes.select2();
}