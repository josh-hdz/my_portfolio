// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
* @type {Array<String, double, double>}
*/
let markers;

/**
 * Fetches needed info for header and calls needed functions to display greeting 
 * and date in header.
 * 
 * @returns None
 */
async function setHeaderData(){
    /**
    * @type {Object Response}
    */
    const responseFromServer = await fetch('/initial-values');
    /**
    * @type {Object json}
    */
    const info = await responseFromServer.json();
    markers =  info[1].markers;

    showDate(info[0].todayDate);
    addRandomGreeting(info[0].chosenGreetings, null);
    setInterval(
        addRandomGreeting,
        5000,
        info[0].chosenGreetings,
        document.getElementById('greeting-container').innerHTML
    );
    placeMapRequest(info[1].apiKey);
}


/**
 * Recursively adds a random greeting to the page's header every 5s.
 * 
 * @param {array of strings} greetings - greetings to schoose from.
 * @param {string} last - last greeting chosen
 * 
 * @return None
 */
function addRandomGreeting(greetings, last) {
  /**
  * @type {Object HTMLParagraphElement}
  */
  const greeter = document.getElementById('greeting-container');
  /**
  * @type {string}
  */
  let chosen = "";

  do{
    chosen = greetings[Math.floor(Math.random() * greetings.length)];
  } while(chosen == last);

  greeter.innerText = chosen + "!";
}

/**
 * Displays the date on page's header.
 * 
 * @returns None
 */
function showDate(date) {
  /**
  * @type {Object HTMLParagraphElement}
  */
  const dateContainer = document.getElementById('date-container');
  dateContainer.innerText = date;
}

async function placeMapRequest(apiKey){
    var js_file = document.createElement('script');
    js_file.type = 'text/javascript';
    js_file.src = 
        'https://maps.googleapis.com/maps/api/js?key=' +
        apiKey +
        '&callback=initMap';
    document.getElementsByTagName('head')[0].appendChild(js_file);
}

/** 
 * Creates a map with maerkes and adds it to the page. 
 * 
 * @returns None.
 */
function initMap() {
    let map = new google.maps.Map(
        document.getElementById("map"),
        {
            center: {lat: 33.1411941, lng: -107.5956095}, 
            zoom: 5,
            mapTypeId: 'terrain'
        }
    );

    markers.forEach(mark => {
        new google.maps.Marker({
            position: {lat: mark.latitude, lng: mark.longitude},
            map,
            title: mark.label
        });    
    });
}