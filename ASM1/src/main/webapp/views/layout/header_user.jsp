<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    a.no-underline {
        text-decoration: none;
    }

    a.no-underline:hover {
        color: darkblue !important;
    }

    .dropdown-link {
        text-decoration: none;
        display: block;
        padding: 5px 0;
        color: black;
    }

    .dropdown-link:hover {
        color: white;
        background-color: #f77f2f;
        border-radius: 4px;
        padding-left: 8px;
    }

    .account-label:hover {
        color: darkblue !important;
    }
</style>

<nav style="background: linear-gradient(to right, orange, yellow); padding: 15px; display: flex; justify-content: space-between; align-items: center;">
    
    <div>
        <a href="${pageContext.request.contextPath}/home" class="no-underline" style="color: darkred; font-weight: bold; font-size: 24px;"> ONLINE ENTERTAINMENT </a>
    </div>

    <div style="display: flex; align-items: center; gap: 25px;">
        <a href="${pageContext.request.contextPath}/favorite"
           class="no-underline"
           style="color: blue; font-weight: bold; font-size: 20px;">
            MY FAVORITES
        </a> 

        <div style="position: relative;">
            <span class="account-label"
                  style="color: blue; font-weight: bold; font-size: 20px; cursor: pointer;"
                  onmouseover="showMenu()" onmouseout="hideMenu()">
                MY ACCOUNT 
            </span>

            <!-- Dropdown -->
            <div id="accountMenu"
                 style="display: none; position: absolute; top: 25px; right: 0;
                        background: white; border: 1px solid #ccc; padding: 10px;
                        box-shadow: 0 0 5px rgba(0,0,0,0.2); z-index: 99;"
                 onmouseover="showMenu()" onmouseout="hideMenu()">
                 
              	<a href="${pageContext.request.contextPath}/login" class="dropdown-link"> Login</a>

                <a href="${pageContext.request.contextPath}/forgot" class="dropdown-link">Forgot Password</a>
                <a href="${pageContext.request.contextPath}/register" class="dropdown-link">Registration</a>
                <a href="${pageContext.request.contextPath}/logoff" class="dropdown-link">Logout</a>
                <%-- <a href="${pageContext.request.contextPath}/change-password" class="dropdown-link">Change Password</a>
                <a href="${pageContext.request.contextPath}/profile" class="dropdown-link">Edit Profile</a> --%>
            </div>
        </div>
    </div>
</nav>

<script>
    function showMenu() {
        document.getElementById("accountMenu").style.display = "block";
    }

    function hideMenu() {
        document.getElementById("accountMenu").style.display = "none";
    }
</script>
