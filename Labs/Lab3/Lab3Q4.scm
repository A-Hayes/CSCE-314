; Asa Hayes & Isabel Ramirez
; CSCE-314-502
; 11 Sep 2020
; Lab 3, Q4: Recursively find min or max val of a list 

(define (min-list-value minval lst)
  (cond  
    [(null? lst) (+ 0 minval) ]
    [(< (car lst) minval) (min-list-value (car lst) (cdr lst))]
    [else (min-list-value minval (cdr lst)) ]
  )
)

(define (max-list-value maxval lst)
  (cond
    [(null? lst) (+ 0 maxval) ]
    [(> (car lst) maxval ) (max-list-value (car lst) (cdr lst))]
    [else (max-list-value maxval (cdr lst)) ]
  )
)

(define (main)
  (display (min-list-value 99999 '(3 8 4 5 1 9) ) ) 
  (newline)
  (display (max-list-value -99999 '(3 8 4 5 1 9) ) ) 
  (newline)
  (display (min-list-value 99999 '(45 -3 7 -9 0) ) ) 
  (newline)
  (display (max-list-value -99999 '(45 -3 7 -9 0) ) ) 
  (newline)
)

(main)
(exit)