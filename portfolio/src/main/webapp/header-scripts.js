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
 * Fetches needed info for header and calls needed functions to display greeting 
 * and date in header.
 */
async function setHeaderData(){
    const responseFromServer = await fetch('/header-handler');
    const info = await responseFromServer.json();

    showDate(info.todayDate);
    addRandomGreeting(info.chosenGreetings);
    setInterval(
        addRandomGreeting,
        5000,
        info.chosenGreetings,
        document.getElementById('greeting-container').innerHTML
    );
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

  greeter.innerText = chosen;
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
