# Paper-Rock-Scissors

Rock paper scissors game. :)

I've made a few assumptions when it comes the design/requirements:
- Rules of the game don't change.
- Drawn rounds are not replayed, therefore the result of n rounds can be a draw, and we can conveniently avoid locks
if say we would let the computer play itself.
- It's always played between at most 2 players (unclear how the game is otherwise played).
- Added an early exit in case the result of the game can no longer change,
- The most interesting part is not so much the semantic of the game, but the strategies we can let the computer employ.
Therefore, we'll make this part the most flexible. 

## How to Run
To run the game, you need Java 21 and Maven. You can use the following commands to package and run the application:
```shell
$ ./mvnw package 
$ java -jar target/paper-rock-scissors-1.0-SNAPSHOT.jar
```
To run the tests:
```shell
$ ./mvnw test
```

You can optionally specify the number of rounds for the game. By default, it's a best of 5:
```shell
$ java -jar target/paper-rock-scissors-1.0-SNAPSHOT.jar <number_of_games>
```

## Strategies used by the Computer

On initialization, the game picks a random strategy for the computer player from the following options:

- **Random**
- **RockSolid**: Always Rock
- **CopyCat**: Copy opponent's last move
- **Winning Strategy**: Looks rather complicated, but you're just moving backwards in the graph.\
See:  [Social cycling and conditional responses in the Rock-Paper-Scissors game](https://arxiv.org/pdf/1404.5199v1)
