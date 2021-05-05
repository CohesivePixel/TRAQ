#!/usr/bin/env node
"use strict";

const fs = require('fs');
const path = require('path');
const inquirer = require('inquirer');
const rimraf = require('rimraf');
const program = require('commander');
const term = require('terminal-kit').terminal();
const authenticate = require('./src/authorize/authenticate.js');
const getData = require('./src/api/get-data');
const getFiles = require('./src/files/get-files');
const buildMatch = require('./src/operations/build-match');

/**
 * Volgorde
 * 1) Haal een nieuw access token op
 * 1) Haal een lijst met alle files op
 * 2) Vraag een Question voor elk nummer
 * 2) Vul elke Choice met gevonden nummers
 * 3) Maak een match van elke Question
 * 4) Sla de match op
 * 4) Pas de metadata van elk nummer aan
 * 5) Pas de filename van elk nummer aan
 */

let trackdir = '/Users/Ben/Music/DISQ-MAP/';

program
    .version('2.12.2', '-v, --version');

program
    .command('setDir <dir>')
    .action((dir) => {
        trackdir = dir;
        term.red.bold('Working Directory >> ');
        term.bold(dir);
        term('\n\n');
    });

program.parse(process.argv);


authenticate()
    .then((spotify) => {
        return Promise.all([
            spotify,
            getFiles(trackdir)
        ]);
    })
    .then((results) => {
        return buildMatch(results[0], results[1]);
    })
    .catch((err) => {
        console.log(err);
    });

// TODO: Keep credentials safe in .env filen
// TODO: Encrypt .keys.json
