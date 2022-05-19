; Asa Hayes & Isabel Ramirez
; CSCE-314-502
; 11 Sep 2020
; Lab 3, Q2: Add atom (arg[1]) at position (arg[2]) into list (arg[3])

(define (addatposition atm indx lst)
  (cond
    [(null? lst) (cons atm '() ) ]
    [(= indx 0) (cons atm lst)]
    [else (append (list (car lst)) (addatposition atm (- indx 1) (cdr lst)) )]
  )
)

(define (main)
  (display (addatposition 2 1 '(5 6 7) ) )  
  (newline)
  (display (addatposition 5 5 '(1 2 5 6 5 3) ) )  
  (newline)
  (display (addatposition 3 0 '(1) ) )  
  (newline)
  (display (addatposition 3 0 '() ) )  
  (newline)
)

(main)
(exit)