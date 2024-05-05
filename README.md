# Dice Assessment

<div>
<h1>Spring Boot Weather API Integration</h1>
    <p>This project utilizes Spring Boot to create a server that integrates the <a href="https://openweathermap.org/api">OpenWeatherMap API</a>. It exposes RESTful APIs to retrieve weather forecast and summary data for any city.</p>
    <h2>Requirements - </h2>
    <p>Implement header-based authentication for accessing two weather forecast APIs to retrieve weather forecast summary and hourly details for any city.</p>
    <h2>API Endpoints</h2>
    <ul>
        <li><strong>API 1:</strong> Get the Weather forecast summary of any city.</li>
        <ul>
            <li>Endpoint: <code>https://spring-boot-backend-api-production.up.railway.app/weather/summary/:city</code></li>
            <li>Method: GET</li>
            <li>Authentication: Header-based authentication with random client id and client secret</li>
        </ul>
        <li><strong>API 2:</strong> Get hourly Weather forecast details of any city.</li>
        <ul>
            <li>Endpoint: <code>https://spring-boot-backend-api-production.up.railway.app/weather/hourly-update/:city</code></li>
            <li>Method: GET</li>
            <li>Authentication: Header-based authentication with random client id and client secret</li>
        </ul>
    </ul>
    
</div>

