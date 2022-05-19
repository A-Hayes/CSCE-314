; Asa Hayes & Isabel Ramirez
; CSCE-314-502
; 11 Sep 2020
; Lab 3, Q3: Creates union of 2 lists; append but no duplicates 

(define (comp atm1 lst2)
  (cond
    [(null? lst2) '()]
    [(eq? atm1 (car lst2) ) (comp atm1 (cdr lst2) ) ]
    [else (append (list (car lst2)) (comp atm1 (cdr lst2)) )]
  )
)

(define (union lst1 lst2)
  (cond
    [(null? lst1) (append lst1 lst2) ]
    [else (append (list (car lst1)) (union (cdr lst1) (comp (car lst1) lst2) ) )]
  )
)

(define (main)
  (display (union '(1 2 3 4) '(4 -1 2 5) ) )
  (newline)
  (display (union '(1 2 3 4) '(1 5 3 7) ) )
  (newline)
  (display (union '(-1 2 -3 4) '(1 -2 3 -4) ) )
  (newline)
  (display (union '(1 2 3) '(1) ) )
  (newline)
  (display (union '() '(6 7 8) ) )
  (newline)
)

(main)
(exit)