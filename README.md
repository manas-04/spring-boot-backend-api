<div>
<h1>Spring Boot Weather API Integration</h1>
    <p>This project utilizes Spring Boot to create a server that integrates the <a href="https://openweathermap.org/api">OpenWeatherMap API</a>. It exposes RESTful APIs to retrieve weather forecast and summary data for any city.</p>
    <h2>Requirements - </h2>
    <p>Implement header-based authentication for accessing two weather forecast APIs to retrieve weather forecast summary and hourly details for any city.</p>
    <h2>API Endpoints</h2>
    <ul>
        <p>Authentication: Header-based authentication with random client id and client secret is included in both api's</p>
        <li><strong>API 1:</strong> Get the Weather forecast summary of any city.</li>
        <ul>
            <li>Endpoint: <code>https://spring-boot-backend-api-production.up.railway.app/weather/summary/:city</code></li>
            <li>Method: GET</li>
        </ul>
        <li><strong>API 2:</strong> Get hourly Weather forecast details of any city.</li>
        <ul>
            <li>Endpoint: <code>https://spring-boot-backend-api-production.up.railway.app/weather/hourly-update/:city</code></li>
            <li>Method: GET</li>
        </ul>
    </ul>
    <p>For Postman Collection Link - <a href="https://drive.google.com/file/d/1dKdYeAZy2SpSSsy-YJ6cRdTNwl6yxgA4/view?usp=sharing">Click Here</a></p>
    <br/>
    <p>In addition to this task, I created login, signup api's as well wherein I used JWT and postgreSQL as well, For this I created a postgreSQL Database on my machine and used it to store the users data.</p>
    <p>Code related to these api's is present in the branch <a href="https://github.com/manas-04/spring-boot-backend-api/tree/postgreSQL-integration">postgreSQL-integration</a></p>
</div>

