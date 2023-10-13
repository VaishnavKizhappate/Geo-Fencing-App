<?php

    include('config.php');

    # Fetching data using POST method...
    $username = $_POST["user_name"];
    $password = $_POST["password"];
    
    
   

   
    $q = "select * from regtable where user_name='$username' and password='$password'";

    $result = mysqli_query($conn, $q);
    $row=mysqli_fetch_row($result);

    if (mysqli_num_rows($result)>0) {
        $response['status'] = "1";
        $response['message'] = "login successful";
        
        $response['id'] = $row[0];
        $response['user_name'] = $row[1];
        $response['password'] = $row[2];
        $response['address'] = $row[3];
        $response['landmark'] = $row[4];
        $response['city'] = $row[5];
        $response['email'] = $row[6];
        $response['phone'] = $row[7];
        $response['guardian'] = $row[8];
        $response['nationality'] = $row[9];
        $response['dob'] = $row[10];
        $response['gender'] = $row[11];

    }
    else {
        $response['status'] = "0";
        $response['message'] = "login failed. Please try again!";
        
        $response['id'] = "";
        $response['user_name'] = "";
        $response['password'] = "";
        $response['address'] = "";
        $response['landmark'] = "";
        $response['city'] = "";
        $response['email'] = "";
        $response['phone'] = "";
        $response['guardian'] = "";
        $response['nationality'] = "";
        $response['dob'] = "";
        $response['gender'] = "";

    }

    
    echo json_encode($response);
?>