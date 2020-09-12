/*Made by Zandoli and Pacini*/

sudoku(R1C1, R1C2, R1C3, R1C4, R1C5, R1C6, R1C7, R1C8, R1C9,
	R2C1, R2C2, R2C3, R2C4, R2C5, R2C6, R2C7, R2C8, R2C9,
	R3C1, R3C2, R3C3, R3C4, R3C5, R3C6, R3C7, R3C8, R3C9,
	R4C1, R4C2, R4C3, R4C4, R4C5, R4C6, R4C7, R4C8, R4C9,
	R5C1, R5C2, R5C3, R5C4, R5C5, R5C6, R5C7, R5C8, R5C9,
	R6C1, R6C2, R6C3, R6C4, R6C5, R6C6, R6C7, R6C8, R6C9,
	R7C1, R7C2, R7C3, R7C4, R7C5, R7C6, R7C7, R7C8, R7C9,
	R8C1, R8C2, R8C3, R8C4, R8C5, R8C6, R8C7, R8C8, R8C9,
	R9C1, R9C2, R9C3, R9C4, R9C5, R9C6, R9C7, R9C8, R9C9) :-
	solved(R1C1, R1C2, R1C3, R1C4, R1C5, R1C6, R1C7, R1C8, R1C9,
	R2C1, R2C2, R2C3, R2C4, R2C5, R2C6, R2C7, R2C8, R2C9,
	R3C1, R3C2, R3C3, R3C4, R3C5, R3C6, R3C7, R3C8, R3C9,
	R4C1, R4C2, R4C3, R4C4, R4C5, R4C6, R4C7, R4C8, R4C9,
	R5C1, R5C2, R5C3, R5C4, R5C5, R5C6, R5C7, R5C8, R5C9,
	R6C1, R6C2, R6C3, R6C4, R6C5, R6C6, R6C7, R6C8, R6C9,
	R7C1, R7C2, R7C3, R7C4, R7C5, R7C6, R7C7, R7C8, R7C9,
	R8C1, R8C2, R8C3, R8C4, R8C5, R8C6, R8C7, R8C8, R8C9,
	R9C1, R9C2, R9C3, R9C4, R9C5, R9C6, R9C7, R9C8, R9C9),
	printsudoku(R1C1, R1C2, R1C3, R1C4, R1C5, R1C6, R1C7, R1C8, R1C9),
	printsudoku(R2C1, R2C2, R2C3, R2C4, R2C5, R2C6, R2C7, R2C8, R2C9),
	printsudoku(R3C1, R3C2, R3C3, R3C4, R3C5, R3C6, R3C7, R3C8, R3C9),
	printsudoku(R4C1, R4C2, R4C3, R4C4, R4C5, R4C6, R4C7, R4C8, R4C9),
	printsudoku(R5C1, R5C2, R5C3, R5C4, R5C5, R5C6, R5C7, R5C8, R5C9),
	printsudoku(R6C1, R6C2, R6C3, R6C4, R6C5, R6C6, R6C7, R6C8, R6C9),
	printsudoku(R7C1, R7C2, R7C3, R7C4, R7C5, R7C6, R7C7, R7C8, R7C9),
	printsudoku(R8C1, R8C2, R8C3, R8C4, R8C5, R8C6, R8C7, R8C8, R8C9),
	printsudoku(R9C1, R9C2, R9C3, R9C4, R9C5, R9C6, R9C7, R9C8, R9C9).

% Helps to print the values
printsudoku(A, B, C, D, E, F, G, H, I) :- write(' '), write(A), write('  '), write(B), write('  '), write(C),
write('  '), write(D), write('  '), write(E), write('  '), write(F),
write('  '), write(G), write('  '), write(H), write('  '), write(I), nl.

% Solves the puzzle by making sure the values are all different
solved(R1C1, R1C2, R1C3, R1C4, R1C5, R1C6, R1C7, R1C8, R1C9,
	R2C1, R2C2, R2C3, R2C4, R2C5, R2C6, R2C7, R2C8, R2C9,
	R3C1, R3C2, R3C3, R3C4, R3C5, R3C6, R3C7, R3C8, R3C9,
	R4C1, R4C2, R4C3, R4C4, R4C5, R4C6, R4C7, R4C8, R4C9,
	R5C1, R5C2, R5C3, R5C4, R5C5, R5C6, R5C7, R5C8, R5C9,
	R6C1, R6C2, R6C3, R6C4, R6C5, R6C6, R6C7, R6C8, R6C9,
	R7C1, R7C2, R7C3, R7C4, R7C5, R7C6, R7C7, R7C8, R7C9,
	R8C1, R8C2, R8C3, R8C4, R8C5, R8C6, R8C7, R8C8, R8C9,
	R9C1, R9C2, R9C3, R9C4, R9C5, R9C6, R9C7, R9C8, R9C9 ):-
	validate(R1C1, R1C2, R1C3, R1C4, R1C5, R1C6, R1C7, R1C8, R1C9), % First row
	validate(R2C1, R2C2, R2C3, R2C4, R2C5, R2C6, R2C7, R2C8, R2C9), % Second row
	validate(R3C1, R3C2, R3C3, R3C4, R3C5, R3C6, R3C7, R3C8, R3C9), % Third row
	validate(R4C1, R4C2, R4C3, R4C4, R4C5, R4C6, R4C7, R4C8, R4C9), % Fourth row
	validate(R5C1, R5C2, R5C3, R5C4, R5C5, R5C6, R5C7, R5C8, R5C9), % Fifth row
	validate(R6C1, R6C2, R6C3, R6C4, R6C5, R6C6, R6C7, R6C8, R6C9), % Sixth row
	validate(R7C1, R7C2, R7C3, R7C4, R7C5, R7C6, R7C7, R7C8, R7C9), % Seventh row
	validate(R8C1, R8C2, R8C3, R8C4, R8C5, R8C6, R8C7, R8C8, R8C9), % Eighth row
	validate(R9C1, R9C2, R9C3, R9C4, R9C5, R9C6, R9C7, R9C8, R9C9), % Nineth row
	validate(R1C1, R2C1, R3C1, R4C1, R5C1, R6C1, R7C1, R8C1, R9C1), % First column
	validate(R1C2, R2C2, R3C2, R4C2, R5C2, R6C2, R7C2, R8C2, R9C2), % Second column
	validate(R1C3, R2C3, R3C3, R4C3, R5C3, R6C3, R7C3, R8C3, R9C3), % Third column
	validate(R1C4, R2C4, R3C4, R4C4, R5C4, R6C4, R7C4, R8C4, R9C4), % Fourth column
	validate(R1C5, R2C5, R3C5, R4C5, R5C5, R6C5, R7C5, R8C5, R9C5), % Fifth column
	validate(R1C6, R2C6, R3C6, R4C6, R5C6, R6C6, R7C6, R8C6, R9C6), % Sixth column
	validate(R1C7, R2C7, R3C7, R4C7, R5C7, R6C7, R7C7, R8C7, R9C7), % Seventh column
	validate(R1C8, R2C8, R3C8, R4C8, R5C8, R6C8, R7C8, R8C8, R9C8), % Eighth column
	validate(R1C9, R2C9, R3C9, R4C9, R5C9, R6C9, R7C9, R8C9, R9C9), % Nineth column
	validate(R1C1, R1C2, R1C3, R2C1, R2C2, R2C3, R3C1, R3C2, R3C3), % Top Left block
	validate(R1C4, R1C5, R1C6, R2C4, R2C5, R2C6, R3C4, R3C5, R3C6), % Top Middle block
	validate(R1C7, R1C8, R1C9, R2C7, R2C8, R2C9, R3C7, R3C8, R3C9), % Top Right block
	validate(R4C1, R4C2, R4C3, R5C1, R5C2, R5C3, R6C1, R6C2, R6C3), % Left block
	validate(R4C4, R4C5, R4C6, R5C4, R5C5, R5C6, R6C4, R6C5, R6C6), % Middle block
	validate(R4C7, R4C8, R4C9, R5C7, R5C8, R5C9, R6C7, R6C8, R6C9), % Right block
	validate(R7C1, R7C2, R7C3, R8C1, R8C2, R8C3, R9C1, R9C2, R9C3), % Bottom Left block
	validate(R7C4, R7C5, R7C6, R8C4, R8C5, R8C6, R9C4, R9C5, R9C6), % Bottom Middle block
	validate(R7C7, R7C8, R7C9, R8C7, R8C8, R8C9, R9C7, R9C8, R9C9). % Bottom Right block


%Utilities

% Determine if each square in either a row, column, or block are
% different

validate(A, B, C, D, E, F, G, H, I) :- num(A), num(B), num(C), num(D), num(E), num(F), num(G), num(H), num(I),
                                        allDifferent(A,[B, C, D, E, F, G, H, I]), allDifferent(B,[C, D, E, F, G, H, I]),
                                        allDifferent(C,[D, E, F, G, H, I]), allDifferent(D,[E, F, G, H, I]),
                                        allDifferent(E,[F, G, H, I]), allDifferent(F,[G, H, I]),
										allDifferent(G,[H, I]), allDifferent(H,[I]).


allDifferent(A, []). 
allDifferent(A, [B|T]) :- A\=B, allDifferent(A, T).

% Initialize numbers
num(1). num(2). num(3). num(4). num(5). num(6). num(7). num(8). num(9).