<!--body div-->
<form action="giocatoreInsert" class="form-horizontal" method="post">
    <fieldset>
        <legend>Register Form</legend>
        <div class="row">
            <div class="form-group">
                <label for="firstNameIn" class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">First Name:</label>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <input id="firstNameIn" name="firstNameIn" type="text" class="form-control" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label for="lastNameIn" class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">Last Name:</label>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <input id="lastNameIn" name="lastNameIn" type="text" class="form-control" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label for="fiscalCodeIn" class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">Fiscal Code:</label>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <input id="fiscalCodeIn" name="fiscalCodeIn" type="text" class="form-control" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label for="mailIn" class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">Mail:</label>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <input id="mailIn" name="mailIn" type="email" class="form-control" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label for="userNameIn" class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">User Name:</label>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <input id="userNameIn" name="userNameIn" placeholder="admin" class="form-control" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label for="passwordIn" class="col-lg-1 col-md-1 col-sm-1 col-xs-1 control-label">Password:</label>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <input id="passwordIn" name="passwordIn" type="password" placeholder="admin" class="form-control" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <input type="submit" class="btn btn-default" value="submit" />
            </div>
        </div>
    </fieldset>
</form>