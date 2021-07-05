def minTime(machines, goal): 
    # make a modest guess of what the days may be, and use it as a starting point
    efficiency = [1.0/x for x in machines]
    lower_bound = int(goal / sum(efficiency)) - 1
    upper_bound = lower_bound + max(machines) + 1
    
    while lower_bound < upper_bound -1:
        days = (lower_bound + upper_bound)//2
        produce = sum([days//x for x in machines])
        if produce >= goal:
            upper_bound = days
        elif produce < goal:
            lower_bound = days
        
    return upper_bound