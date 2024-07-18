import React, { useState } from 'react';

const LadderDrawing = ({ participants, onGameStart }) => {
    const [names, setNames] = useState(Array.from({ length: participants }, () => ''));
    const [prizes, setPrizes] = useState(Array.from({ length: participants }, () => ''));

    const handleNameChange = (index, value) => {
        const newNames = [...names];
        newNames[index] = value;
        setNames(newNames);
    };

    const handlePrizeChange = (index, value) => {
        const newPrizes = [...prizes];
        newPrizes[index] = value;
        setPrizes(newPrizes);
    };

    const handleStartGame = () => {
        // 사다리 게임 로직을 추가해야 합니다.
        const results = names.map((name, index) => {
            // 여기서 결과를 계산하는 로직을 추가합니다.
            return prizes[index];
        });
        onGameStart(results);
    };

    return (
        <div>
            <h1>이름과 당첨항목을 적어주세요.</h1>
            <div>
                {names.map((name, index) => (
                    <div key={index}>
                        <input
                            type="text"
                            value={name}
                            onChange={(e) => handleNameChange(index, e.target.value)}
                            placeholder="이름"
                        />
                        <input
                            type="text"
                            value={prizes[index]}
                            onChange={(e) => handlePrizeChange(index, e.target.value)}
                            placeholder="당첨항목"
                        />
                    </div>
                ))}
            </div>
            <button onClick={handleStartGame}>사다리 시작</button>
        </div>
    );
};

export default LadderDrawing;
