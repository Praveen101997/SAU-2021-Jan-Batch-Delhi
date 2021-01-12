function getdata(){
    var firstname = document.getElementById("fname").value;
    var lastname = document.getElementById("lname").value;
    var emailid = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var repassword = document.getElementById("repassword").value;
    var gender = displayRadioValue();
    var e = document.getElementById("country");
    var country = e.options[e.selectedIndex].text;


    document.getElementById('fname').style.borderColor = "#ccc";
    document.getElementById('lname').style.borderColor = "#ccc";
    document.getElementById('email').style.borderColor = "#ccc"; 
    document.getElementById('password').style.borderColor = "#ccc";
    document.getElementById('repassword').style.borderColor = "#ccc";
    document.getElementById('country').style.borderColor = "#ccc";
    // document.getElementById('fname').style.borderColor = "red"; 
    // document.getElementById('fname').style.borderColor = "red"; 
    // document.getElementById('fname').style.borderColor = "red"; 
    // document.getElementById('fname').style.borderColor = "red"; 
    // document.getElementById('fname').style.borderColor = "red"; 

    //==============================================
    if (firstname==null || firstname==""){  
        document.getElementById('fname').style.borderColor = "red";
        alert("First Name can't be blank"); 
        return false;  
    }else if (lastname==null || lastname==""){
        document.getElementById('lname').style.borderColor = "red";  
        alert("Last Name can't be blank");  
        return false; 
    }
    else if(!validateEmail(emailid)){
        document.getElementById('email').style.borderColor = "red";
        alert("Please Enter valid email id");  
        return false;
    }
    else if(password.length<6){
        document.getElementById('password').style.borderColor = "red";
        alert("Password must be at least 6 char long");  
        return false;
    }else if(password!=repassword){
        document.getElementById('repassword').style.borderColor = "red";
        alert("Password not matched");  
        return false;
    }else if(gender==null || gender==""){
        alert("Please Select Gender");
        return false;
    }else if(e.value=="select"){
        document.getElementById('country').style.borderColor = "red";
        alert("Please Select your Country");
        return false;
    }

    //==============================================
    var detail_JSON = {};
    detail_JSON['First Name'] = firstname;
    detail_JSON['Last Name'] = lastname;
    detail_JSON['Email Id'] = emailid;
    detail_JSON['Password'] = password;
    detail_JSON['Gender'] = gender;
    detail_JSON['Country'] = country;

    console.log(detail_JSON);
    GenerateTable(detail_JSON);
}

function validateEmail(email){  
    if(email==""){
        return false;
    }
    var atposition=email.indexOf("@");  
    var dotposition=email.lastIndexOf(".");  
    if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){ 
        return false;  
    }else{
        return true;
    }   
}


function displayRadioValue() { 
    var ele = document.getElementsByName('radio'); 
      
    for(i = 0; i < ele.length; i++) { 
        if(ele[i].checked){
            return ele[i].value;
        } 
    } 
} 


function GenerateTable(detail_JSON) {
    //Build an array containing Customer records.
    // var customers = JSON.parse(detail_JSON);
    var customers = [['Key','Value']];
    for(var i in detail_JSON)
    customers.push([i,detail_JSON[i]]);

    //Create a HTML Table element.
    var table = document.createElement("TABLE");
    table.id = 'customers'
    table.border = "1";

    //Get the count of columns.
    var columnCount = customers[0].length;

    //Add the header row.
    var row = table.insertRow(-1);
    for (var i = 0; i < columnCount; i++) {
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = customers[0][i];
        row.appendChild(headerCell);
    }

    //Add the data rows.
    for (var i = 1; i < customers.length; i++) {
        row = table.insertRow(-1);
        for (var j = 0; j < columnCount; j++) {
            var cell = row.insertCell(-1);
            cell.innerHTML = customers[i][j];
        }
    }

    var dvTable = document.getElementById("dvTable");
    dvTable.innerHTML = "";
    dvTable.appendChild(table);
}