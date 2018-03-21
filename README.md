# Examples for (Domain-Driven Design) Aggregates
This project tries to demo ways for implementing Aggregates that are compliant with Domain-Driven Design's ideas.

There are currently two examples:
- A scoring engine for loans
- A battery of an electric vehicle


## Current status
Please consider this a first code drop that contains most of my views and ideas but this code drop is not yet documented or finalized. 
I consider the scoring example to be more complete than the battery one.

## Ideas
I think that aggregates are a good way and a suitable place to implement information hiding on a rather low level module level. 
Please note how I operate with visibility operators on a class, attribute and method level. All I have publicly visible here are the Aggregate classes themselves but not the (Root)entities or Value Objects.

## Scoring Engine
The scoring engine example demos a few aggregates (applicant, agency,...) but also show how different aggregates can be combined or orchestrated with application services
