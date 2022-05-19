; Asa Hayes & Isabel Ramirez
; CSCE-314-502
; 11 Sep 2020
; Lab 3, Q5: Find a mid value from a list 

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

;issue somewhere in conditional, not able to change from 1st value

(define (middle-value lst minfunc maxfunc midval)
  (cond
    [(and (= midval -99999 ) (null? lst)) '()]
    [(null? lst) (+ 0 midval) ]
    [(and (< (car lst) (maxfunc -99999 lst)) (> (car lst) (minfunc 99999 lst))) 
      (+ 0 (car lst))]
    [(= midval -99999) (middle-value (cdr lst) minfunc maxfunc (car lst) )]
    [else (middle-value (cdr lst) minfunc maxfunc midval)]
  )
)

(define (main)
  (display (middle-value '(10 20 15) min-list-value max-list-value -99999 ) ) 
  (newline)
  (display (middle-value '(3 10 4 0) min-list-value max-list-value -99999 ) ) 
  (newline)
  (display (middle-value '() min-list-value max-list-value -99999 ) ) 
  (newline)
  (display (middle-value '(5 8) min-list-value max-list-value -99999 ) ) 
  (newline)
)

(main)
(exit)