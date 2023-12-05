/**
 * @param {number} n
 * @return {number}
 */
var numberOfMatches = function(numberOfTeams) {
    let roundsPlayed = 0;
    let carryOver = 0;
    while (numberOfTeams > 1) {

        carryOver = numberOfTeams % 2 === 0 ? 0 : 1;

        numberOfTeams = Math.floor(numberOfTeams / 2);
        roundsPlayed += numberOfTeams

        numberOfTeams += carryOver;
    }

    return roundsPlayed;
};

/**
 * @param {number} n
 * @return {number}
 */
var numberOfMatches2 = function(numberOfTeams) {
    return numberOfTeams - 1;
};
