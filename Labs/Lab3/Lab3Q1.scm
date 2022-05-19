; Asa Hayes & Isabel Ramirez
; CSCE-314-502
; 11 Sep 2020
; Lab 3, Q1: Recursive function to halve all atoms in a list

(define (half x) (/ x 2))

(define (map func lst)
  (if (null? lst) '()
    (cons (func (car lst)) (map func (cdr lst)))
  )
)

(define (half-everything lst)
  (map half lst)
)

(define (main)
  (display (half-everything '(8 10 20 5) ) ) ; should output (4 5 10 2.5)
  (newline)
  (display (half-everything '()) ) ; should output () or nothing
  (newline)
)

(main)
(exit)