; Asa Hayes & Isabel Ramirez
; CSCE-314-502
; 4 Sep 2020
; Lab 2, Q2: Returns letter grade based on input score 

(define (letter-grade score)
  (cond
    [(< score 60) "F"]
    [(< score 70) "D"]
    [(< score 80) "C"]
    [(< score 90) "B"]
    [else "A"] 
  )
)

(define (main)
  (display (letter-grade 0) )
  (newline)
  (display (letter-grade 75) )
  (newline)
  (display (letter-grade 95) )
  (newline)
)

(main)
(exit)