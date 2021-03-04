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
 * Feches needed info for header and calls needed fucntions to display greeting 
 * and date in header.
 */
async function setHeaderData(){
    const responseFromServer = await fetch('/header-handler');
    const info = await responseFromServer.json();

    showDate(info.todayDate);
    addRandomGreeting(info.chosenGreetings);
}


/**
 * Adds a random greeting to the page's header every 5s.
 */
function addRandomGreeting(greetings, last=null) {
  const greeter = document.getElementById('greeting-container');
  let chosen = "";

  do{
    chosen = greetings[Math.floor(Math.random() * greetings.length)];
  } while(chosen == last);

  greeter.innerText = chosen;
  setInterval(addRandomGreeting, 5000, greetings, chosen);
}

/**
 * displays the date on page's header.
 */
function showDate(date) {
  const dateContainer = document.getElementById('date-container');
  dateContainer.innerText = date;
}
