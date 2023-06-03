<!DOCTYPE html>
<html>
<head>
  <title>Report Information</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }
    .container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
    h1 {
     text-align: center;
    margin-bottom: 20px
    }
    form {
      width: 400px;
      margin: 0 auto;
    }
    label {
      display: block;
      margin-bottom: 10px;
    }
    input[type="date"],
    input[type="text"],
    select {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    select {
      height: 32px;
    }
    input[type="file"] {
      margin-top: 5px;
    }
    input[type="submit"] {
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
  </style>
  <script>
      function populateCities() {
      var countrySelect= document.getElementById("countrySelect");
      var citySelect= document.getElementById("citySelect");
      var selectedCountry = countrySelect.options[countrySelect.selectedIndex].value;      
      citySelect.innerHTML = "";
      if (selectedCountry === "usa") {
        var cities= ["NewYork", "Los Angeles", "Chicago", "Houston"];
      }else if(selectedCountry === "uk") {
        var cities= ["London", "Manchester", "Birmingham", "Glasgow"];
      } else if(selectedCountry === "uae") {
        var cities= ["Dubai", "Sharjah", "AbuDhabi","Fujairah"];
      } else if(selectedCountry === "jordan"){
    	  var cities= ["Amman", "Aqaba", "Irbid", "WadiRam"];
      }
       for(var i=0;i<cities.length;i++){
        var option = document.createElement("option");
        option.text=cities[i];
        option.value=cities[i];
        citySelect.add(option);
        }
    }
  </script>
</head>
<body>
  <form action="test" method="post">
    <div class="container">
    <h1>Select City : </h1>
    <div>
      <label>Country: </label>
      <select name="CS" id="countrySelect" onchange="populateCities()">
        <option value="">Select a country</option>
        <option value="usa">United States</option>
        <option value="jordan">Jordan</option>
        <option value="uk">United Kingdom</option>
        <option value="uae">Emirates</option>
      </select>
    </div>
    <br>
    <div>
      <label>City:</label>
      <select name="CITY" id="citySelect">
        <option value="">Select a city</option>
      </select>
    </div>
    <br>
   
    <br>
    <div>
      <input type="submit" value="Submit">
    </div>
    </div>
  </form>
</body>
</html>