# CardGame
An interesting, exciting and brain-tasking card game.

This is a card game that can be played by 1 player. The goal is for the
player to discard all of the cards in the deck by discarding a card into any
of four discard piles (per move).
Two of the discard piles start at 1 and cards are played in ascending order; only cards greater
than the card on the top may be played unless the card is exactly 10 less than the card on the
top. For example, if the top card on the pile is 27, then any card greater than 27 may be played
on the pile or a 17 may be played (because it is exactly 10 less).
The other two discard piles start at 100 and cards are played in descending order; only cards
less than the card on the top may be played unless the card is exactly 10 more than the card on
top. For example, if the top card on the pile is 66, then any card less than 66 may be played on
the pile or a 76 may be played (because it is exactly 10 greater).

The deck contains 18 cards numbered from 2 to 19. A player is dealt a hand of 6 cards. On a player's turn, he/she must play at least two cards
(but may play as many cards as desired). At the end of a turn, he/she draws enough cards to
replace any that was played.
The game is won if the player manages to play all of the cards in the deck. If a player is
unable to play at least two cards in a turn, the game is lost.
