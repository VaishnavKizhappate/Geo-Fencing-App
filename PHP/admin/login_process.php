<?php

    $username=$_POST["username"];
    $password=$_POST['password'];
    
    // echo $username . ", " . $password;

    session_start();

	if($username=="admin" && $password=="admin")
	{
	    // $_SESSION['admin']=$myusername;
        // header('Location:admin_index.php');
        
        ?>
        <script language="javascript">
            window.location.replace('home.html');
        </script>
        <?php
        
	} else {
	    
	    ?>
        <script language="javascript">
            alert('Invalid username or password');
            window.location.replace('index.html');
        </script>
        <?php
	    
	}

?>