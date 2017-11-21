function addFlashcard() {
  let newQuestion = document.getElementById('new-question').value;
  let newAnswer = document.getElementById('new-answer').value;


  let newElement = document.createElement('tr');
  let questiontd = document.createElement('td');
  questiontd.innerText = newQuestion;
  let answertd = document.createElement('td');
  answertd.innerText = newAnswer

  newElement.appendChild(questiontd);
  newElement.appendChild(answertd);

  document.getElementById('flashcard-table-body').appendChild(newElement);
  
//   document.getElementById('flashcard-table-body')
// 	.innerHTML += `
// 	<tr>
// 		<td>
// 			${newQuestion}
// 		</td>
// 		<td>
// 			${newAnswer}
// 		</td>
// 	</tr>
// `;
}